package com.qdesrame.openapi.diff.compare;

import static com.qdesrame.openapi.diff.utils.ChangedUtils.isChanged;
import static com.qdesrame.openapi.diff.utils.ChangedUtils.isUnchanged;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.qdesrame.openapi.diff.model.ChangedContent;
import com.qdesrame.openapi.diff.model.ChangedMediaType;
import com.qdesrame.openapi.diff.model.ChangedOperationMetadata;
import com.qdesrame.openapi.diff.model.DiffContext;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;

public class OperationMetadataDiff implements Comparable<Operation> {

    private OpenApiDiff openApiDiff;

    public OperationMetadataDiff(OpenApiDiff openApiDiff) {
        this.openApiDiff = openApiDiff;
    }

    public Optional<ChangedOperationMetadata> diff(Operation left, Operation right, DiffContext context) {
        ChangedOperationMetadata changedOperationMetadata = new ChangedOperationMetadata(left, right, context);
        
        if(left != null && left.getDescription() != null 
                && right != null && right.getDescription() != null) {
            if(!left.getDescription().equals(right.getDescription())) {
                changedOperationMetadata.setDescription(right.getDescription());
            }
        }
        
        if(left != null && left.getSummary() != null 
                && right != null && right.getSummary() != null) {
            if(!left.getDescription().equals(right.getSummary())) {
                changedOperationMetadata.setSummary(right.getSummary());
            }
        }

        return isChanged(changedOperationMetadata);
    }
    
    @Override
    public boolean compare(Operation left, Operation right) {
        // TODO Auto-generated method stub
        return false;
    }
    
}