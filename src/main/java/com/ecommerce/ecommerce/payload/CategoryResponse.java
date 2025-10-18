package com.ecommerce.ecommerce.payload;


import com.ecommerce.ecommerce.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private List<CategoryDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;
    private Long totalElements;
    private Boolean lastPage;
}
