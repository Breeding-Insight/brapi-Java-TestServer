package io.swagger.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.BrAPIResponse;
import io.swagger.model.Context;
import io.swagger.model.Metadata;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * BatchResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class BatchResponse implements BrAPIResponse<BatchDetails> {
	@JsonProperty("@context")
	private Context _atContext = null;

	@JsonProperty("metadata")
	private Metadata metadata = null;

	@JsonProperty("result")
	private BatchDetails result = null;

	public BatchResponse() {
		this._atContext = new Context();
		this._atContext.add("context");
	}

	public BatchResponse metadata(Metadata metadata) {
		this.metadata = metadata;
		return this;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public BatchResponse result(BatchDetails result) {
		this.result = result;
		return this;
	}

	public BatchDetails getResult() {
		return result;
	}

	public void setResult(BatchDetails result) {
		this.result = result;
	}

	@Override
	public void set_atContext(Context _atContext) {
		this._atContext = _atContext;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BatchResponse BatchResponse = (BatchResponse) o;
		return Objects.equals(this._atContext, BatchResponse._atContext)
				&& Objects.equals(this.metadata, BatchResponse.metadata)
				&& Objects.equals(this.result, BatchResponse.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_atContext, metadata, result);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BatchResponse {\n");

		sb.append("    _atContext: ").append(toIndentedString(_atContext)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    result: ").append(toIndentedString(result)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}