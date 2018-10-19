package com.qdesrame.openapi.diff.compare;

import static com.qdesrame.openapi.diff.utils.ChangedUtils.isChanged;

import java.util.Optional;

import com.qdesrame.openapi.diff.model.ChangedOperationMetadata;
import com.qdesrame.openapi.diff.model.DiffContext;

import io.swagger.v3.oas.models.Operation;

/**
 * A class which will compare a new operation to an old operation and determine if it has changed.
 * @author Mark
 */
public class OperationMetadataDiff implements Comparable<Operation> {

    private OpenApiDiff openApiDiff;

    public OperationMetadataDiff(OpenApiDiff openApiDiff) {
        this.openApiDiff = openApiDiff;
    }

    public Optional<ChangedOperationMetadata> diff(Operation left, Operation right, DiffContext context) {
        ChangedOperationMetadata changedOperationMetadata = new ChangedOperationMetadata(left, right, context);
        
        if(left != null && right != null) {
            changedOperationMetadata.setOldDescription(left.getDescription());
            changedOperationMetadata.setDescription(right.getDescription());
        }
        
        if(left != null && right != null) {
            changedOperationMetadata.setOldSummary(left.getSummary());
            changedOperationMetadata.setSummary(right.getSummary());
        }

        return isChanged(changedOperationMetadata);
    }
    
    @Override
    public boolean compare(Operation left, Operation right) {
        // TODO Auto-generated method stub
        return false;
    }
    
}