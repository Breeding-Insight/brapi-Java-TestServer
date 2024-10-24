/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.geno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Model202AcceptedSearchResponse;
import io.swagger.model.geno.Call;
import io.swagger.model.geno.CallsListResponse;
import io.swagger.model.geno.CallsSearchRequest;
import io.swagger.annotations.*;

import java.util.List;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
@Api(value = "calls", description = "the calls API")
public interface CallsApi {

	@ApiOperation(value = "Gets a filtered list of `Calls`", nickname = "callsGet", notes = "Gets a filtered list of `Call` JSON objects.  ** THIS ENDPOINT USES TOKEN BASED PAGING **", response = CallsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Calls", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CallsListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/calls", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<CallsListResponse> callsGet(
			@ApiParam(value = "The ID of the `CallSet` to be retrieved.") @Valid @RequestParam(value = "callSetDbId", required = false) String callSetDbId,
			@ApiParam(value = "The ID of the `Variant` to be retrieved.") @Valid @RequestParam(value = "variantDbId", required = false) String variantDbId,
			@ApiParam(value = "The ID of the `VariantSet` to be retrieved.") @Valid @RequestParam(value = "variantSetDbId", required = false) String variantSetDbId,
			@ApiParam(value = "Should homozygotes be expanded (true) or collapsed into a single occurence (false)") @Valid @RequestParam(value = "expandHomozygotes", required = false) Boolean expandHomozygotes,
			@ApiParam(value = "The string to use as a representation for missing data") @Valid @RequestParam(value = "unknownString", required = false) String unknownString,
			@ApiParam(value = "The string to use as a separator for phased allele calls") @Valid @RequestParam(value = "sepPhased", required = false) String sepPhased,
			@ApiParam(value = "The string to use as a separator for unphased allele calls") @Valid @RequestParam(value = "sepUnphased", required = false) String sepUnphased,
			@ApiParam(value = "Used to request a specific page of data to be returned.  Tokenized pages are for large data sets which can not be efficiently broken into indexed pages. Use the nextPageToken and prevPageToken from a prior response to construct a query and move to the next or previous page respectively. ") @Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Submit a search request for `Calls`", nickname = "searchCallsPost", notes = "Submit a search request for `Calls`  ** THIS ENDPOINT USES TOKEN BASED PAGING **", response = CallsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Calls", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CallsListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/calls", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<? extends BrAPIResponse> searchCallsPost(
			@ApiParam(value = "Study Search request") @Valid @RequestBody CallsSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Returns a filtered list of `Call` JSON objects.", nickname = "searchCallsSearchResultsDbIdGet", notes = "Returns a filtered list of `Call` JSON objects.  See Search Services for additional implementation details.  ** THIS ENDPOINT USES TOKEN BASED PAGING **", response = CallsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Calls", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CallsListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/calls/{searchResultsDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<? extends BrAPIResponse> searchCallsSearchResultsDbIdGet(
			@ApiParam(value = "searchResultsDbId", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "pageToken") @Valid @RequestParam(value = "pageToken", required = false) String pageToken,
			@ApiParam(value = "pageSize") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "Authorization") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update existing `Calls` with new genotype value or metadata", notes = "Update existing `Calls` with new genotype value or metadata <br/>Implementation Note -  <br/>A `Call` object does not have a DbId of its own. It is defined by the unique combination of  `callSetDbId`, `variantDbId`, and `variantSetDbId`. These three fields MUST be present for every  `call` update request. This endpoint should not allow these fields to be modified for a given  `call`. Modifying these fields in the database is effectively moving a cell to a different location in the genotype matrix. This action is dangerous and can cause data collisions.     ", response = CallsListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Calls", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = CallsListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/calls", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<CallsListResponse> callsPut(
			@ApiParam(value = "request") @Valid @RequestBody List<Call> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

}
