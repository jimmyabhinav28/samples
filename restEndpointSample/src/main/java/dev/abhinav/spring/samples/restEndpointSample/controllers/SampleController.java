package dev.abhinav.spring.samples.restEndpointSample.controllers;


import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.abhinav.spring.samples.restEndpointSample.models.Parameter;
import dev.abhinav.spring.samples.restEndpointSample.models.SampleGetCallResponseModel;
import dev.abhinav.spring.samples.restEndpointSample.models.SamplePostCallResponseModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/samples")
public class SampleController
{
	
	@ApiOperation(value = "",response = SampleGetCallResponseModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
//	Added the @ApiResponses()
	@GetMapping(path="/getSampleEndpoint/{pathParameter1}/{pathParameter2}")
	public SampleGetCallResponseModel showAllParametersInGetRequest(@RequestHeader HttpHeaders requestHeaders,@RequestParam Map<String,String> allQueryParameters,Model model, @PathVariable String pathParameter1,@PathVariable String pathParameter2)
	{
		SampleGetCallResponseModel response=new SampleGetCallResponseModel();
		ArrayList<Parameter> queryParameters=new ArrayList<Parameter>();
		ArrayList<Parameter> headers=new ArrayList<Parameter>();
		ArrayList<Parameter> pathParameters=new ArrayList<Parameter>();
		
		pathParameters.add(new Parameter("pathParameter1", pathParameter1));
		pathParameters.add(new Parameter("pathParameter2", pathParameter2));
		
		for(String queryParameter: allQueryParameters.keySet())
		{
			String queryParameterValue=allQueryParameters.get(queryParameter);
			queryParameters.add(new Parameter(queryParameter, queryParameterValue));
		}
		
		for(String header: requestHeaders.keySet())
		{
			String headerValue=requestHeaders.get(header).toString();
			headers.add(new Parameter(header, headerValue));
		}
		
		response.setHeaders(headers);
		response.setPathParameters(pathParameters);
		response.setQueryParameters(queryParameters);
		
		return response;
	}
	
	@ApiOperation(value = "",response = SampleGetCallResponseModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
//	Added the @ApiResponses()
	@PostMapping(path="/postSampleEndpoint/{pathParameter1}/{pathParameter2}")
	public SamplePostCallResponseModel showAllParametersInPostRequest(@RequestHeader HttpHeaders requestHeaders,@RequestParam Map<String,String> allQueryParameters,Model model, @PathVariable String pathParameter1,@PathVariable String pathParameter2, @RequestBody String requestBody)
	{
		SamplePostCallResponseModel response=new SamplePostCallResponseModel();
		ArrayList<Parameter> queryParameters=new ArrayList<Parameter>();
		ArrayList<Parameter> headers=new ArrayList<Parameter>();
		ArrayList<Parameter> pathParameters=new ArrayList<Parameter>();
		
		pathParameters.add(new Parameter("pathParameter1", pathParameter1));
		pathParameters.add(new Parameter("pathParameter2", pathParameter2));
		
		for(String queryParameter: allQueryParameters.keySet())
		{
			String queryParameterValue=allQueryParameters.get(queryParameter);
			queryParameters.add(new Parameter(queryParameter, queryParameterValue));
		}
		
		for(String header: requestHeaders.keySet())
		{
			String headerValue=requestHeaders.get(header).toString();
			headers.add(new Parameter(header, headerValue));
		}
		
		response.setHeaders(headers);
		response.setPathParameters(pathParameters);
		response.setQueryParameters(queryParameters);
		response.setRequestBody(requestBody);
		return response;
	}
}
