package be.mddpharma.management.model;

import be.mddpharma.management.enums.Status;
import be.mddpharma.management.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    @Enumerated(EnumType.STRING)
    public Type type;
    @Enumerated(EnumType.STRING)
    public Status status;

}
