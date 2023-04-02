package com.example.springexerciseproject.web.v1.dtos.review;

import java.util.Objects;

public class UpdateReviewDTO {
    private Integer numberOfStars;
    private String reviewDescription;

    public boolean hasNumberOfStars(){
        return Objects.nonNull(numberOfStars);
    }

    public static UpdateReviewDTOBuilder builder() {
        return new UpdateReviewDTOBuilder();
    }

    public Integer getNumberOfStars() {
        return this.numberOfStars;
    }

    public String getReviewDescription() {
        return this.reviewDescription;
    }

    public void setNumberOfStars(final Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public void setReviewDescription(final String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UpdateReviewDTO)) {
            return false;
        } else {
            UpdateReviewDTO other = (UpdateReviewDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$numberOfStars = this.getNumberOfStars();
                Object other$numberOfStars = other.getNumberOfStars();
                if (this$numberOfStars == null) {
                    if (other$numberOfStars != null) {
                        return false;
                    }
                } else if (!this$numberOfStars.equals(other$numberOfStars)) {
                    return false;
                }

                Object this$reviewDescription = this.getReviewDescription();
                Object other$reviewDescription = other.getReviewDescription();
                if (this$reviewDescription == null) {
                    if (other$reviewDescription != null) {
                        return false;
                    }
                } else if (!this$reviewDescription.equals(other$reviewDescription)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateReviewDTO;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $numberOfStars = this.getNumberOfStars();
        result = result * 59 + ($numberOfStars == null ? 43 : $numberOfStars.hashCode());
        Object $reviewDescription = this.getReviewDescription();
        result = result * 59 + ($reviewDescription == null ? 43 : $reviewDescription.hashCode());
        return result;
    }

    public String toString() {
        return "UpdateReviewDTO(numberOfStars=" + this.getNumberOfStars() + ", reviewDescription=" + this.getReviewDescription() + ")";
    }

    public UpdateReviewDTO() {
    }

    public UpdateReviewDTO(final Integer numberOfStars, final String reviewDescription) {
        this.numberOfStars = numberOfStars;
        this.reviewDescription = reviewDescription;
    }

    public static class UpdateReviewDTOBuilder {
        private Integer numberOfStars;
        private String reviewDescription;

        UpdateReviewDTOBuilder() {
        }

        public UpdateReviewDTOBuilder numberOfStars(final Integer numberOfStars) {
            this.numberOfStars = numberOfStars;
            return this;
        }

        public UpdateReviewDTOBuilder reviewDescription(final String reviewDescription) {
            this.reviewDescription = reviewDescription;
            return this;
        }

        public UpdateReviewDTO build() {
            return new UpdateReviewDTO(this.numberOfStars, this.reviewDescription);
        }

        public String toString() {
            return "UpdateReviewDTO.UpdateReviewDTOBuilder(numberOfStars=" + this.numberOfStars + ", reviewDescription=" + this.reviewDescription + ")";
        }
    }

}
