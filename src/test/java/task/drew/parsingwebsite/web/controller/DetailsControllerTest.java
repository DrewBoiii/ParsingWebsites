package task.drew.parsingwebsite.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import task.drew.parsingwebsite.persistence.model.WebSite;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDetailsPage_whenUrlCorrect_statusOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/details").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("details"))
                .andExpect(MockMvcResultMatchers.model().attribute("websites", new ArrayList<WebSite>()))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getErrorPage_whenUrlIncorrect_statusNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/someincorrecturl").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NOT_FOUND.value()))
                .andDo(MockMvcResultHandlers.print());
    }

}
