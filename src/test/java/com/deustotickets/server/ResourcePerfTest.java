package com.deustotickets.server;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.deustotickets.domain.Usuario;
import com.github.javatlacati.contiperf.PerfTest;
import com.github.javatlacati.contiperf.Required;
import com.github.javatlacati.contiperf.junit.ContiPerfRule;

public class ResourcePerfTest {

//	@Rule
//	public JUnitPerfRule rule = new JUnitPerfRule(new HtmlReportGenerator("target/junitperf/report.html"));
	
	@Rule 
	public ContiPerfRule rule = new ContiPerfRule();
	
	Usuario user = new Usuario();
	
	@Before
	public void setUp() throws Exception {
        user.setEmail("example@example.com");
        user.setPassword("password");
        
        Resource.registerUser(user);
	}

	@After
	public void tearDown() throws Exception {
		Resource.deleteAccount(user);
	}

    @Test
    @PerfTest
    @Required(average = 300, percentile95 = 500)
    public void testLoginUser() {
        Response response = Resource.loginUser(user);
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }
	
	@Test
	@PerfTest()
    @Required()
	public void testGetConcerts() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testRegisterUser() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testChangeUsername() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testChangePassword() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testDeleteAccount() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testModifyConcert() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testAddConcert() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testDeleteConcert() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testVerifyArtist() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testBanUser() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testGetUsers() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testGetArtists() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testBuyTicket() {
	}
	
	@Test
	@PerfTest()
    @Required()
	public void testUpdateUserTickets() {
	}

}
