package com.test.spring.boot.readfile;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Db2Dbcompare {
	
	public void compare(String source, List<String> destinations, String feeschid) {
        // Your logic for comparing the source with the destinations
        System.out.println("Source: " + source);
        System.out.println("Destinations: " + destinations);
        System.out.println("Fee Schdule ID: " + feeschid);
        
        // Perform validation or comparison logic here
        // Throw exceptions or handle errors if needed
    }

}
