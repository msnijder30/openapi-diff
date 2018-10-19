package com.qdesrame.openapi.diff.model;

import java.util.Objects;

import io.swagger.v3.oas.models.Operation;
import lombok.Getter;
import lombok.Setter;

/**
 * A class which will keep track of summaries and descriptions and its changes.
 * @author Mark
 */
@Getter
@Setter
public class ChangedOperationMetadata implements Changed {
    
    private final Operation left;
    private final Operation right;
    private final DiffContext context;

    private String oldSummary;
    private String oldDescription;
    private String summary;
    private String description;
    
    public ChangedOperationMetadata(Operation left, Operation right, DiffContext context) {
        this.left = left;
        this.right = right;
        this.context = context;
    }

    @Override
    public DiffResult isChanged() {
        if(!isSummaryChanged()
                && !isDescriptionChanged()) {
            return DiffResult.NO_CHANGES;
        }
        
        //TODO Add a way that it's not compatible?
        return DiffResult.COMPATIBLE;
    }
    
    public boolean isSummaryChanged() {
        // We use Objects.equals since that will also null check before calling .equals()
        return !Objects.equals(oldSummary, summary);
    }
    
    public boolean isDescriptionChanged() {
        // We use Objects.equals since that will also null check before calling .equals()
        return !Objects.equals(oldDescription, description);
    }

}
