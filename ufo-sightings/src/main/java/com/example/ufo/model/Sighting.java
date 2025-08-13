package com.example.ufo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "sightings")
public class Sighting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Location é obrigatório")
    private String location;

    @NotNull(message = "Date and time é obrigatório")
    @PastOrPresent(message = "Date and time não pode estar no futuro")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") // compatível com input datetime-local
    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @NotBlank(message = "Color é obrigatório")
    private String color;

    @NotNull(message = "Shape é obrigatório")
    @Enumerated(EnumType.STRING)
    private ShapeType shape;

    @Min(value = 1, message = "Quantity deve ser >= 1")
    private int quantity;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public ShapeType getShape() { return shape; }
    public void setShape(ShapeType shape) { this.shape = shape; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
