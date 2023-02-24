package fun;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
//import org.junit.runner.RunWith;
//import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

//@RunWith(MockitoJUnitRunner.class)
public class GameTests {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	GameController gameController;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new GameController()).build();
	}

	@Test
	public void test1() {
		GameController gc1 = new GameController();
		assertThat(gc1.greeting("Ludo").getText(), containsString("Playing"));
	}

	@Test
	public void serviceTest1() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/game");
		mockMvc.perform(requestBuilder).andExpect(status().isOk());//.andExpect(content().string("Playing"));
	}
	
	@Test
	public void serviceTest2() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/game");
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		String stringResult = result.getResponse().getContentAsString();
		assertThat(stringResult,containsString("Playing"));
	}
	@Test
	public void serviceTest3() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/game");
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		String stringResult = result.getResponse().getContentAsString();
		assertThat(stringResult,containsString("1"));
	}
}
