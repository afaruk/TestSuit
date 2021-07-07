package testsuit.scenario.json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import testsuit.operations.bind.BindOperationConfig;
import testsuit.operations.search.SearchOperationConfig;
import testsuit.operations.OperationType;

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
