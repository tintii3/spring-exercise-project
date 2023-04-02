package com.example.springexerciseproject.utils.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true, fluent = true)
public class MovieCriteria {

    private boolean includeActors;

    public boolean isIncludeActors() {
        return includeActors;
    }

    public void setIncludeActors(boolean includeActors) {
        this.includeActors = includeActors;
    }
}
