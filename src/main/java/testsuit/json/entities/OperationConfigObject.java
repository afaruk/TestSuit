package testsuit.json.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import testsuit.json.entities.operations.BindOperationConfig;
import testsuit.json.entities.operations.SearchOperationConfig;
import testsuit.operation.OperationType;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BindOperationConfig.class, name = "BindOperation"),
        @JsonSubTypes.Type(value = SearchOperationConfig.class, name = "SearchOperation"),
})
public interface OperationConfigObject extends JSonObject {

    OperationType getOperationName();

}
