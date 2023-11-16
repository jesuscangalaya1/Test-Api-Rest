package com.avatar.util;

import java.util.List;

public final class AppConstants {

    private AppConstants(){}

    // PRODUCTS ERRORS
    public static final String BAD_REQUEST = "P-404";
    public static final String BAD_REQUEST_PRODUCT = "Producto no encontrado con el ID: ";

    //MESSAGE CONTROLLER
    public static final String SUCCESS = "SUCCESS";
    public static final String MESSAGE_ID_PRODUCT = "PRODUCT ID: ";


    // =============================================================================================
    // CONSTANTES DE PAGINATION
    // =============================================================================================
    public static final String NUMERO_DE_PAGINA_POR_DEFECTO = "1";
    public static final String MEDIDA_DE_PAGINA_POR_DEFECTO = "10";
    public static final String ORDENAR_POR_DEFECTO = "id";
    public static final String ORDENAR_DIRECCION_POR_DEFECTO = "asc";

    // =============================================================================================
    // TIPOS DE FORMATOS DE ARCHIVOS
    // =============================================================================================
    /** FORMATO_ARCHIVOS */
    public static final String FORMAT_EXCEL = ".xlsx";
    public static final String FORMAT_PDF = ".pdf";

    public static final String FORMATO_EXCEL_ABREVIATURA_MINUS = "excel";
    public static final String FORMATO_EXCEL_ABREVIATURA = "EXCEL";
    public static final String FORMATO_PDF_ABREVIATURA = "PDF";
    public static final String FORMATO_PDF_ABREVIATURA_MINUS = "pdf";
    public static final List<String> ARRAY_FORMATO = List.of(FORMATO_EXCEL_ABREVIATURA,
                                FORMATO_PDF_ABREVIATURA,
                                FORMATO_EXCEL_ABREVIATURA_MINUS,
                                FORMATO_PDF_ABREVIATURA_MINUS);

    /** ERROR_REPORTE */
    public static final String ERROR_REPORTE = "Ocurrió un error al generar el reporte";

    // =============================================================================================
    // TIPOS DE FORMATOS DE ARCHIVOS
    // =============================================================================================
    /** FORMATO_ARCHIVOS */
    public static final String SHEET_PRODUCT = "Lista De Productos";
    public static final String VC_EMTY = "-";
    // =============================================================================================
    // NOMBRE DE REPORTES Y COLUMNAS DE 'PRODUCTOS'
    // =============================================================================================
    public static final String REPORT_NAME_PRODUCT_PAGINABLE = "report-productos";

    // Constantes para las columnas de la hoja de cálculo
    public static final String COL_PRODUCT_ID = "ID";
    public static final String COL_PRODUCT_NAME = "NOMBRE";
    public static final String COL_PRODUCT_DESCRIPTION = "DESCRIPTION";
    public static final String COL_PRODUCT_PRICE = "PRECIO";
    public static final String COL_PRODUCT_STOCK = "STOCK";



}
