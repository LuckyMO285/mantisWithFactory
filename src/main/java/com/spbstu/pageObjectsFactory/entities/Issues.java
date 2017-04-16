package com.spbstu.pageObjectsFactory.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by luck on 16.04.17.
 */

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Issues {

    String summary;
    String description;

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }
}
