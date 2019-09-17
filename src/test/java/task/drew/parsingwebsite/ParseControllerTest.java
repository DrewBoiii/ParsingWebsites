package task.drew.parsingwebsite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import task.drew.parsingwebsite.persistence.model.WebSite;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getParserPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/parser").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("parser"))
                .andExpect(MockMvcResultMatchers.model().attribute("website", new WebSite()));
    }

    @Test
    public void getNotParserPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/someincorrecturl").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(404));
    }

    // TODO: 17.09.2019 do assertion true
    @Test
    public void processParserPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/parser/submit").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
