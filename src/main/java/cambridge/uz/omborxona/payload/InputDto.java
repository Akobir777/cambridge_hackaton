package cambridge.uz.omborxona.payload;

import cambridge.uz.omborxona.entity.Currency;
import cambridge.uz.omborxona.entity.Supplier;
import cambridge.uz.omborxona.entity.Warehouse;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class InputDto {
    private Timestamp date;
    private Integer warehouse_id;
    private Integer supplier_id;
    private Integer currency_id;
    private String factureNumber;
    private String code;
}
