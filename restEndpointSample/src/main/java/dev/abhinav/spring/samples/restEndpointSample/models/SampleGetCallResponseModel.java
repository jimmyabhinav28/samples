package dev.abhinav.spring.samples.restEndpointSample.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleGetCallResponseModel 
{
	List<Parameter> queryParameters;
	List<Parameter> pathParameters;
	List<Parameter> headers;
	 
}
