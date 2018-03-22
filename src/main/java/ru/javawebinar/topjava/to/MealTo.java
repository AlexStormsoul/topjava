package ru.javawebinar.topjava.to;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

public class MealTo extends BaseTo implements Serializable {

    @NotNull
    private String dateTime;

    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @Column(name = "calories", nullable = false)
    @Range(min = 10, max = 5000)
    private int calories;

    public MealTo() {
    }

    public MealTo(Integer id, @NotNull String dateTime, @NotBlank @Size(min = 2, max = 120) String description, @Range(min = 10, max = 5000) int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }


}
