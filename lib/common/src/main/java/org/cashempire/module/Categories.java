package org.cashempire.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String categoryId;
    private String categoryName;
    private String desktopOrder;
    private String mobileOrder;
    private boolean status;
    private String createdOn;
    private String updatedOn;
}
