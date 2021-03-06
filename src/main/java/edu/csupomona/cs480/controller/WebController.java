package edu.csupomona.cs480.controller;

//import com.google.gson.Gson;
import com.google.common.base.Joiner;
import java.util.List;

import org.scribe.model.Request;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;



import edu.csupomona.cs480.App;
import edu.csupomona.cs480.Game;
import edu.csupomona.cs480.ScribeRequest;
import edu.csupomona.cs480.data.GpsProduct;
import edu.csupomona.cs480.data.User;
import edu.csupomona.cs480.data.provider.GpsProductManager;
import edu.csupomona.cs480.data.provider.UserManager;

import org.apache.commons.math3.distribution.*;
import org.apache.commons.math3.stat.descriptive.*;
import java.util.Random;
import org.uncommons.maths.random.*;

/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
	@Autowired
	private UserManager userManager;
	@Autowired
	private GpsProductManager gpsProductManager;

	/**
	 * mases example
	 */
	@RequestMapping(value = "/masesk", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "Mases Krikorian was here";
	}
	
	/**
	 * sean example
	 */
	@RequestMapping(value = "/sean", method = RequestMethod.GET)
	String seanHereString() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "Sean Castillo was here";
	}
        
        /**
	 * john zubiri example
	 */
	@RequestMapping(value = "/johnz", method = RequestMethod.GET)
	String johnPeasant() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "Zug-zug.";
	}
        
                /**
	 * new john zubiri gson example
	 */
	@RequestMapping(value = "/johnz/GSON", method = RequestMethod.GET)
	Game johnGson() {
		// commented by Sean until we fix the pom
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
                String json = "{\"Brand\":\"Rockstar Games\", \"Title\": \"Red Dead Redemption II\", \"Price\": \"$60\"}";
                //Gson gson = new Gson();
		//Game redDead = gson.fromJson(json, Game.class);
             //   return redDead;
                return new Game();
	}
	
	@RequestMapping(value = "/sean/guava", method = RequestMethod.GET)
	String seanGuava() {
		Joiner joiner = Joiner.on("; ").skipNulls();
		 return joiner.join("Harry", null, "Ron", "Hermione");
	}
	
	@RequestMapping(value = "/masesk/scribe", method = RequestMethod.GET)
	String MasesK() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
                String URL = "https://opentdb.com/api.php?amount=10";
                Request request = new Request(Verb.GET, URL);
                Response resp = request.send();
                return resp.getBody();
	}
	
        
        
        
        
	/**
	 * Varoozhan example OkHttp
	 */
	@RequestMapping(value = "/varoozhan", method = RequestMethod.GET)
	String VaroozhanHereString() {
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
	
	/**
	 * Sarmen example A4
	 */
	@RequestMapping(value = "/sarmena1990", method = RequestMethod.GET)
	String samWasHere() {
		Random rng=new MersenneTwisterRNG();
		
		
		DescriptiveStatistics stats= new DescriptiveStatistics();
		
		
		DescriptiveStatistics myMaxVal= new DescriptiveStatistics();
		
		
		for(int j=0;j<5;j++) {
			stats.clear();
		
		for(int i=0;i<2000;i++) {
			myMaxVal.clear();
			
			NormalDistribution myND1=new NormalDistribution(55.0,15.0);
			myMaxVal.addValue(myND1.inverseCumulativeProbability(rng.nextDouble()));
			
			NormalDistribution myND2=new NormalDistribution(580.0,30.0);
			myMaxVal.addValue(myND2.inverseCumulativeProbability(rng.nextDouble()));
			
			NormalDistribution myND3=new NormalDistribution(190.0,65.0);
			myMaxVal.addValue(myND3.inverseCumulativeProbability(rng.nextDouble()));
			
			stats.addValue(myMaxVal.getMax());
			
			
			}
		System.out.println("Num of elements: "+ stats.getN());
		System.out.println("Mean of dist of max: "+ stats.getMean());
		System.out.println("std dev of dist of max: "+stats.getStandardDeviation()+"\n" );
	  }
		
	}

	}

	/**
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs480/user/user101
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.GET)
	User getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		return user;
	}
	
	@RequestMapping(value = "/masesk/test", method = RequestMethod.GET)
	String masesk() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "Mases Krikorian was here";
	}

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs480/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param major
	 * @return
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "major", required = false) String major) {
		User user = new User();
		user.setId(id);
		user.setMajor(major);
		user.setName(name);
		userManager.updateUser(user);
		return user;
	}

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userId") String userId) {
		userManager.deleteUser(userId);
	}

	/**
	 * This API lists all the users in the current database.
	 *
	 * @return
	 */
	@RequestMapping(value = "/cs480/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}
	
	@RequestMapping(value = "/cs480/gps/list", method = RequestMethod.GET)
	List<GpsProduct> listGpsProducts() {
		return gpsProductManager.listAllGpsProducts();
	}

	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs480/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllUsers());
		return modelAndView;
	}

}
