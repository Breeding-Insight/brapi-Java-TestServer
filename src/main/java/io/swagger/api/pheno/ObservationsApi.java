/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.pheno;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.Model202AcceptedSearchResponse;
import io.swagger.model.WSMIMEDataTypes;
import io.swagger.model.pheno.ObservationListResponse;
import io.swagger.model.pheno.ObservationNewRequest;
import io.swagger.model.pheno.ObservationSearchRequest;
import io.swagger.model.pheno.ObservationSingleResponse;
import io.swagger.model.pheno.ObservationTableResponse;

import io.swagger.annotations.*;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
@Api(value = "observations", description = "the observations API")
public interface ObservationsApi {

	@ApiOperation(value = "Get a filtered set of Observations", nickname = "observationsGet", notes = "Retrieve all observations where there are measurements for the given observation variables.  observationTimestamp should be ISO8601 format with timezone -> YYYY-MM-DDThh:mm:ss+hhmm", response = ObservationListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Observations", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ObservationListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/observations", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<ObservationListResponse> observationsGet(
			@ApiParam(value = "The unique ID of an Observation Unit") @Valid @RequestParam(value = "observationDbId", required = false) String observationDbId,
			@ApiParam(value = "The unique ID of an Observation Unit") @Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@ApiParam(value = "The unique ID of a germplasm (accession) to filter on") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@ApiParam(value = "The unique ID of an observation variable") @Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@ApiParam(value = "The unique ID of a studies to filter on") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@ApiParam(value = "The unique ID of a location where these observations were collected") @Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@ApiParam(value = "The unique ID of a trial to filter on") @Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@ApiParam(value = "The unique ID of a program to filter on") @Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@ApiParam(value = "The year or Phenotyping campaign of a multi-annual study (trees, grape, ...)") @Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@ApiParam(value = "The Observation Unit Level. Returns only the observation unit of the specified Level. References ObservationUnit->observationUnitPosition->observationLevel->levelName") @Valid @RequestParam(value = "observationUnitLevelName", required = false) String observationUnitLevelName,
			@ApiParam(value = "The Observation Unit Level Order Number. Returns only the observation unit of the specified Level. References ObservationUnit->observationUnitPosition->observationLevel->levelOrder") @Valid @RequestParam(value = "observationUnitLevelOrder", required = false) String observationUnitLevelOrder,
			@ApiParam(value = "The Observation Unit Level Code. This parameter should be used together with `observationUnitLevelName` or `observationUnitLevelOrder`. References ObservationUnit->observationUnitPosition->observationLevel->levelCode") @Valid @RequestParam(value = "observationUnitLevelCode", required = false) String observationUnitLevelCode,
			@ApiParam(value = "Timestamp range start") @Valid @RequestParam(value = "observationTimeStampRangeStart", required = false) String observationTimeStampRangeStart,
			@ApiParam(value = "Timestamp range end") @Valid @RequestParam(value = "observationTimeStampRangeEnd", required = false) String observationTimeStampRangeEnd,
			@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@ApiParam(value = "Search for Germplasm by an external reference") @Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get the details of a specific Observations", nickname = "observationsObservationDbIdGet", notes = "Get the details of a specific Observations  observationTimestamp should be ISO8601 format with timezone -> YYYY-MM-DDThh:mm:ss+hhmm", response = ObservationSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Observations", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ObservationSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/observations/{observationDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<ObservationSingleResponse> observationsObservationDbIdGet(
			@ApiParam(value = "The unique ID of an observation", required = true) @PathVariable("observationDbId") String observationDbId,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update an existing Observation", nickname = "observationsObservationDbIdPut", notes = "Update an existing Observation", response = ObservationSingleResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Observations", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ObservationSingleResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/observations/{observationDbId}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<ObservationSingleResponse> observationsObservationDbIdPut(
			@ApiParam(value = "The unique ID of an observation", required = true) @PathVariable("observationDbId") String observationDbId,
			@ApiParam(value = "") @Valid @RequestBody ObservationNewRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Add new Observation entities", nickname = "observationsPost", notes = "Add new Observation entities", response = ObservationListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Observations", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ObservationListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/observations", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<ObservationListResponse> observationsPost(
			@ApiParam(value = "") @Valid @RequestBody List<ObservationNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Update multiple Observation entities", nickname = "observationsPut", notes = "Update multiple Observation entities simultaneously with a single call  Include as many `observationDbIds` in the request as needed.  Note - In strictly typed languages, this structure can be represented as a Map or Dictionary of objects and parsed directly from JSON.", response = ObservationListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Observations", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ObservationListResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class),
			@ApiResponse(code = 404, message = "Not Found", response = String.class) })
	@RequestMapping(value = "/observations", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	ResponseEntity<ObservationListResponse> observationsPut(
			@ApiParam(value = "") @Valid @RequestBody Map<String, ObservationNewRequest> body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Get a list of Observations in a table format", nickname = "observationsTableGet", notes = "<p>This service is designed to retrieve a table of time dependant observation values as a matrix of Observation Units and Observation Variables. This is also sometimes called a Time Series. This service takes the \"Sparse Table\" approach for representing this time dependant data.</p> <p>The table may be represented by JSON, CSV, or TSV. The \"Accept\" HTTP header is used for the client to request different return formats.  By default, if the \"Accept\" header is not included in the request, the server should return JSON as described below.</p> <p>The table is REQUIRED to have the following columns</p> <ul>   <li>observationUnitDbId - Each row is related to one Observation Unit</li>   <li>observationTimeStamp - Each row is has a time stamp for when the observation was taken</li>   <li>At least one column with an observationVariableDbId</li> </ul> <p>The table may have any or all of the following OPTIONAL columns. Included columns are decided by the server developer</p> <ul>   <li>observationUnitName</li>   <li>studyDbId</li>   <li>studyName</li>   <li>germplasmDbId</li>   <li>germplasmName</li>   <li>positionCoordinateX</li>   <li>positionCoordinateY</li>   <li>year</li> </ul> <p>The table also may have any number of Observation Unit Hierarchy Level columns. For example:</p> <ul>   <li>field</li>   <li>plot</li>   <li>sub-plot</li>   <li>plant</li>   <li>pot</li>   <li>block</li>   <li>entry</li>   <li>rep</li> </ul> <p>The JSON representation provides a pair of extra arrays for defining the headers of the table.  The first array \"headerRow\" will always contain \"observationUnitDbId\" and any or all of the OPTIONAL column header names.  The second array \"observationVariables\" contains the names and DbIds for the Observation Variables represented in the table.  By appending the two arrays, you can construct the complete header row of the table. </p> <p>For CSV and TSV representations of the table, an extra header row is needed to describe both the Observation Variable DbId and the Observation Variable Name for each data column.  See the example responses below</p> ", response = ObservationTableResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Observations", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ObservationTableResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/observations/table", produces = { "application/json", "text/csv",
			"text/tsv" }, method = RequestMethod.GET)
	ResponseEntity<ObservationTableResponse> observationsTableGet(
			@ApiParam(value = "The requested content type which should be returned by the server", required = true) @RequestHeader(value = "Accept", required = false) String accept,
			@ApiParam(value = "The unique ID of an Observation Unit") @Valid @RequestParam(value = "observationUnitDbId", required = false) String observationUnitDbId,
			@ApiParam(value = "The unique ID of a germplasm (accession) to filter on") @Valid @RequestParam(value = "germplasmDbId", required = false) String germplasmDbId,
			@ApiParam(value = "The unique ID of an observation variable") @Valid @RequestParam(value = "observationVariableDbId", required = false) String observationVariableDbId,
			@ApiParam(value = "The unique ID of a studies to filter on") @Valid @RequestParam(value = "studyDbId", required = false) String studyDbId,
			@ApiParam(value = "The unique ID of a location where these observations were collected") @Valid @RequestParam(value = "locationDbId", required = false) String locationDbId,
			@ApiParam(value = "The unique ID of a trial to filter on") @Valid @RequestParam(value = "trialDbId", required = false) String trialDbId,
			@ApiParam(value = "The unique ID of a program to filter on") @Valid @RequestParam(value = "programDbId", required = false) String programDbId,
			@ApiParam(value = "The year or Phenotyping campaign of a multi-annual study (trees, grape, ...)") @Valid @RequestParam(value = "seasonDbId", required = false) String seasonDbId,
			@ApiParam(value = "The type of the observationUnit. Returns only the observation unit of the specified type; the parent levels ID can be accessed through observationUnitStructure.") @Valid @RequestParam(value = "observationLevel", required = false) String observationLevel,
			@ApiParam(value = "Permanent unique identifier which references the search results") @Valid @RequestParam(value = "searchResultsDbId", required = false) String searchResultsDbId,
			@ApiParam(value = "Timestamp range start") @Valid @RequestParam(value = "observationTimeStampRangeStart", required = false) String observationTimeStampRangeStart,
			@ApiParam(value = "Timestamp range end") @Valid @RequestParam(value = "observationTimeStampRangeEnd", required = false) String observationTimeStampRangeEnd,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Submit a search request for a set of Observations", nickname = "searchObservationsPost", notes = "Submit a search request for a set of Observations. Returns an Id which reference the results of this search", response = ObservationListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Observations", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ObservationListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/observations", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<? extends BrAPIResponse> searchObservationsPost(
			@ApiParam(value = "") @Valid @RequestBody ObservationSearchRequest body,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException;

	@ApiOperation(value = "Returns a list of Observations based on search criteria.", nickname = "searchObservationsSearchResultsDbIdGet", notes = "Returns a list of Observations based on search criteria.  observationTimeStamp - Iso Standard 8601.  observationValue data type inferred from the ontology", response = ObservationListResponse.class, authorizations = {
			@Authorization(value = "AuthorizationToken") }, tags = { "Observations", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = ObservationListResponse.class),
			@ApiResponse(code = 202, message = "Accepted", response = Model202AcceptedSearchResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = String.class),
			@ApiResponse(code = 403, message = "Forbidden", response = String.class) })
	@RequestMapping(value = "/search/observations/{searchResultsDbId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	ResponseEntity<? extends BrAPIResponse> searchObservationsSearchResultsDbIdGet(
			@ApiParam(value = "The requested content type which should be returned by the server", required = true) @RequestHeader(value = "Accept", required = true) WSMIMEDataTypes accept,
			@ApiParam(value = "Permanent unique identifier which references the search results", required = true) @PathVariable("searchResultsDbId") String searchResultsDbId,
			@ApiParam(value = "HTTP HEADER - Token used for Authorization   <strong> Bearer {token_string} </strong>") @RequestHeader(value = "Authorization", required = false) String authorization,
			@ApiParam(value = "Used to request a specific page of data to be returned.  The page indexing starts at 0 (the first page is 'page'= 0). Default is `0`.") @Valid @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "The size of the pages to be returned. Default is `1000`.") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize)
			throws BrAPIServerException;

}
