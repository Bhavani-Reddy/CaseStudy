package com.search.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.search.entity.FlightDetails;
import com.search.service.SearchService;
import com.search.service.SearchServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class SearchController 
{
	@Autowired
	private SearchService adminService;
	
	@GetMapping("/allflights")
	public List<FlightDetails> getAllDetails()
	{
		return adminService.getAllDetails();
	}
	
	@GetMapping("/status/{pnrNo}")
	public String getStatus(@PathVariable long pnrNo)
	{
		return adminService.pnrStatus(pnrNo);
	}
	
	@GetMapping("/flightNo/{flightNo}")
	public FlightDetails getDetailsByflightNo(@PathVariable int flightNo) 
	{
		return adminService.getDetailsByFlightNo(flightNo);
	}
	
	@GetMapping("/{startPoint}/{endPoint}/{flightDate}")
//	@ApiOperation(value="Get Flight details by giving startPoint and endPoint locations and date")
	public List<FlightDetails> getFlightDetailsByStartStation(@PathVariable String startPoint,@PathVariable String endPoint,@PathVariable String flightDate)
	{
	//System.out.println(startPoint +" "+ endPoint+" " +flightDate);
	return adminService.findByStartPointAndEndPointAndFlightDate(startPoint, endPoint, flightDate);
	}
}