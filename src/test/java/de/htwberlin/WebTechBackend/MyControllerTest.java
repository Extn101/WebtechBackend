package de.htwberlin.WebTechBackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MyControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private WatchlistService watchlistService;

    @InjectMocks
    private MyController myController;

    WatchlistEntry RECORD_1 = new WatchlistEntry(1L, "The Matrix", 1);
    WatchlistEntry RECORD_2 = new WatchlistEntry(2L, "Iron Man", 2);
    WatchlistEntry RECORD_3 = new WatchlistEntry(3L, "Challengers", 3);

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(myController).build();

    }

    @Test
    public void getAllMovies_success() throws Exception {
        List<WatchlistEntry> watchlistEntries = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(watchlistService.getAll()).thenReturn(watchlistEntries);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/watchlist")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].titel", is("Challengers")))
                .andExpect(jsonPath("$", notNullValue()));
    }

    @Test
    public void createWatchlistEntry_failure() throws Exception {
        List<WatchlistEntry> watchlistEntries = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(watchlistService.movieExistsInWatchlist(1)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/watchlist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(RECORD_1)))
                .andExpect(status().isConflict())
                .andExpect(content().string("Movie already exists in the watchlist"));
    }

    @Test
    public void createWatchlistEntry_success() throws Exception {
        WatchlistEntry RECORD_4 = new WatchlistEntry(4L, "Saltburn", 4);

        Mockito.when(watchlistService.saveWatchlistEntry((ArgumentMatchers.any(WatchlistEntry.class)))).thenReturn(RECORD_4);

        String content = objectWriter.writeValueAsString(RECORD_4);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/watchlist")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.titel", is("Saltburn")));

    }

    @Test
    public void deleteWatchlistEntry_success() throws Exception {
        long idToDelete = 1L;
        Mockito.doNothing().when(watchlistService).delete(idToDelete);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/watchlist/" + idToDelete)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(watchlistService, Mockito.times(1)).delete(idToDelete);
        // If the method is not called, or is called with a different argument, or is called more than once, the test will fail.

    }


}



