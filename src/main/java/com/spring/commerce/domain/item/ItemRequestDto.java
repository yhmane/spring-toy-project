package com.spring.commerce.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author hwang-yunho on 2020. 2. 3.
 * @project commerce
 */
@NoArgsConstructor
@Getter
@Setter
public class ItemRequestDto {

    @NotBlank(message = "상품명을 입력하여 주세요.")
    @Pattern(regexp = "[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣0-9\\s+]{1,50}", message = "한글,숫자,영문 50자 이내로 작성하여 주세요.")
    private String name;

    @Max(100000000)
    @Min(1)
    private int price;

    @Max(100000000)
    @Min(0)
    private int stockQuantity;

    @Builder
    public ItemRequestDto(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();
    }
}
