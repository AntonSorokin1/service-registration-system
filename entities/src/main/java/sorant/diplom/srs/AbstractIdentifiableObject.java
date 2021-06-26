package sorant.diplom.srs;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class AbstractIdentifiableObject {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
}
