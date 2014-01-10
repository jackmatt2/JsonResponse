@JsonResponse
=============

Jackson mixin support for spring controllers using annotations.

Example
=======

Simply annotate your @RequestMapping method with @JsonResponse and pass an array of @JsonMixin's to apply.

	@RequestMapping("/customers/summary")
	@JsonResponse(mixins = {
			@JsonMixin(target=Customer.class, mixin=Customer.SummaryMixin.class),
			@JsonMixin(target=Address.class, mixin=Address.SummaryMixin.class)
	})
	public @ResponseBody List<Customer> listSummary()
	{
		return data;
	}
	
Servlet Configuration
---------------------

Modify your spring configuration as follows:

	<annotation-driven>
		<message-converters>
			<beans:bean class="io.jackmatthews.jsonresponse.JsonResponseAwareJsonMessageConverter" />
		</message-converters>
	</annotation-driven>
	
	<beans:bean class="io.jackmatthews.jsonresponse.JsonResponseSupportFactoryBean" />
	
Which Project?
==============
core - required

spring3jackson1 - for Spring 3.x and Jackson 1.9.x

spring4jackson2 - for Spring 4.x and Jackson 2.x

Acknowledgements
================
The project is based on the @ResponseView project by martypitt
https://github.com/martypitt/JsonViewExample
	



