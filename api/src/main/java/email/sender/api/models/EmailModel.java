package email.sender.api.models;

import email.sender.api.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity(name = "Email")
@Table(name = "emails")

public class EmailModel implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String ownerRef;
    private String emailFrom;
    private String emailTo;

    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
}
