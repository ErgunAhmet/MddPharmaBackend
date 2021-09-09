package be.mddpharma.management.dto;

import be.mddpharma.management.enums.Status;
import be.mddpharma.management.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto {
    public String name;
    public Type type;
    public Status status;
}
