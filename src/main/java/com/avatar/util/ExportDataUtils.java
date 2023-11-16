package com.avatar.util;


import com.avatar.dto.response.ProductResponse;
import com.avatar.exceptions.BusinessException;
import org.springframework.http.HttpStatus;

import java.util.*;

import static com.avatar.util.AppConstants.*;


public final class ExportDataUtils {

    private ExportDataUtils(){}

    //Validated Format
    public static void validateFormato(String formato) {
        if (!ARRAY_FORMATO.contains(formato)) {
            throw new BusinessException(String.format("%s format not allowed", formato), HttpStatus.BAD_GATEWAY, "Bad");
        }
    }

    //Mapeando Columnas
    public static Map<String, List<String>> createColumnsBySheetMap() {
        List<String> cols = Arrays.asList(
                COL_PRODUCT_ID,
                COL_PRODUCT_NAME,
                COL_PRODUCT_DESCRIPTION,
                COL_PRODUCT_PRICE,
                COL_PRODUCT_STOCK

        );

        Map<String, List<String>> colsBySheet = new HashMap<>();
        colsBySheet.put(SHEET_PRODUCT, cols);
        return colsBySheet;
    }

    public static Map<String, List<Map<String, String>>> createValuesBySheetMap(List<ProductResponse> productResponses) {
        List<Map<String, String>> valoresHoja = new ArrayList<>();

        for (ProductResponse product : productResponses) {
            Map<String, String> valuesHojaRow = new HashMap<>();
            valuesHojaRow.put(COL_PRODUCT_ID, getStringValue(product.getId()));
            valuesHojaRow.put(COL_PRODUCT_NAME, getStringValue(product.getName()));
            valuesHojaRow.put(COL_PRODUCT_DESCRIPTION, getStringValue(product.getDescription()));
            valuesHojaRow.put(COL_PRODUCT_PRICE, getStringValue(product.getPrice()));
            valuesHojaRow.put(COL_PRODUCT_STOCK, getStringValue(product.getStock()));

            valoresHoja.add(valuesHojaRow);
        }

        Map<String, List<Map<String, String>>> valuesBySheet = new HashMap<>();
        valuesBySheet.put(SHEET_PRODUCT, valoresHoja);
        return valuesBySheet;
    }

    private static String getStringValue(Object value) {
        return value != null ? value.toString() : VC_EMTY;
    }
}

