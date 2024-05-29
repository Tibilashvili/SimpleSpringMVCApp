package ua.tibilashvili.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;

    @NotEmpty(message = "Title must not be empty")
    @Size(min = 2, max = 60, message = "Title must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Title must contain only letters")
    private String title;

    @NotEmpty(message = "Author's first name must not be empty")
    @Size(min = 2, max = 50, message = "Author's first name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Author's first name must contain only letters")
    private String authorFirstName;

    @NotEmpty(message = "Author's last name must not be empty")
    @Size(min = 2, max = 50, message = "Author's last name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Author's last name must contain only letters")
    private String authorLastName;

    @Min(value = 1300, message = "Year must be later than 1300")
    private int year;
}
