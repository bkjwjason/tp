package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.animal.Animal;

/**
 * Container for user visible messages.
 */
public class AnimalMessages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%s";
    public static final String MESSAGE_INVALID_ANIMAL_DISPLAYED_INDEX = "The animal index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%d animals listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
            "Multiple values specified for the following single-valued field(s): ";
    public static final String PET_ID = "ID";
    public static final String SEX = "Sex";
    public static final String SPECIES = "Species";
    public static final String BREED = "Breed";
    public static final String DATE_OF_BIRTH = "Date of Birth";
    public static final String ADMISSION_DATE = "Date of Admission";
    public static final String DISPLAY_FORMAT = "; %s:";


    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code animal} for display to the user.
     */
    public static String format(Animal animal) {
        StringBuilder builder = new StringBuilder();
        builder.append(animal.getName())
                .append(String.format(DISPLAY_FORMAT, PET_ID))
                .append(animal.getPetId())
                .append(String.format(DISPLAY_FORMAT, SEX))
                .append(animal.getSex())
                .append(String.format(DISPLAY_FORMAT, SPECIES))
                .append(animal.getSpecies())
                .append(String.format(DISPLAY_FORMAT, BREED))
                .append(animal.getBreed())
                .append(String.format(DISPLAY_FORMAT, DATE_OF_BIRTH))
                .append(animal.getDateOfBirth())
                .append(String.format(DISPLAY_FORMAT, ADMISSION_DATE))
                .append(animal.getAdmissionDate());
        return builder.toString();
    }

}
