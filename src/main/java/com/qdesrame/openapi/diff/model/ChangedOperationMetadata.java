package com.qdesrame.openapi.diff.model;

import io.swagger.v3.oas.models.Operation;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Mark
 */
@Getter
@Setter
public class ChangedOperationMetadata implements Changed {
    
    private final Operation left;
    private final Operation right;
    private final DiffContext context;

    private String summary;
    private String description;
    
    public ChangedOperationMetadata(Operation left, Operation right, DiffContext context) {
        this.left = left;
        this.right = right;
        this.context = context;
    }

    @Override
    public DiffResult isChanged() {
        if(summary == null && description == null) {
            return DiffResult.NO_CHANGES;
        }
        
        //FIXME Add a way that it's not compatible?
        return DiffResult.COMPATIBLE;
    }

}
