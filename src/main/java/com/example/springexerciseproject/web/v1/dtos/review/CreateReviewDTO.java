package com.example.springexerciseproject.web.v1.dtos.review;

import java.util.Objects;

public class CreateReviewDTO {private Integer numberOfStars;
    private String reviewDescription;
    private Integer movieId;

    public boolean hasMovieId() {
        return Objects.nonNull(this.movieId);
    }

    public boolean hasNumberOfStars() {
        return Objects.nonNull(this.numberOfStars);
    }

    public static CreateReviewDTOBuilder builder() {
        return new CreateReviewDTOBuilder();
    }

    public Integer getNumberOfStars() {
        return this.numberOfStars;
    }

    public String getReviewDescription() {
        return this.reviewDescription;
    }

    public Integer getMovieId() {
        return this.movieId;
    }

    public void setNumberOfStars(final Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public void setReviewDescription(final String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public void setMovieId(final Integer movieId) {
        this.movieId = movieId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CreateReviewDTO)) {
            return false;
        } else {
            CreateReviewDTO other = (CreateReviewDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$numberOfStars = this.getNumberOfStars();
                    Object other$numberOfStars = other.getNumberOfStars();
                    if (this$numberOfStars == null) {
                        if (other$numberOfStars == null) {
                            break label47;
                        }
                    } else if (this$numberOfStars.equals(other$numberOfStars)) {
                        break label47;
                    }

                    return false;
                }

                Object this$movieId = this.getMovieId();
                Object other$movieId = other.getMovieId();
                if (this$movieId == null) {
                    if (other$movieId != null) {
                        return false;
                    }
                } else if (!this$movieId.equals(other$movieId)) {
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
        return other instanceof CreateReviewDTO;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $numberOfStars = this.getNumberOfStars();
        result = result * 59 + ($numberOfStars == null ? 43 : $numberOfStars.hashCode());
        Object $movieId = this.getMovieId();
        result = result * 59 + ($movieId == null ? 43 : $movieId.hashCode());
        Object $reviewDescription = this.getReviewDescription();
        result = result * 59 + ($reviewDescription == null ? 43 : $reviewDescription.hashCode());
        return result;
    }

    public String toString() {
        return "CreateReviewDTO(numberOfStars=" + this.getNumberOfStars() + ", reviewDescription=" + this.getReviewDescription() + ", movieId=" + this.getMovieId() + ")";
    }

    public CreateReviewDTO() {
    }

    public CreateReviewDTO(final Integer numberOfStars, final String reviewDescription, final Integer movieId) {
        this.numberOfStars = numberOfStars;
        this.reviewDescription = reviewDescription;
        this.movieId = movieId;
    }

    public static class CreateReviewDTOBuilder {
        private Integer numberOfStars;
        private String reviewDescription;
        private Integer movieId;

        CreateReviewDTOBuilder() {
        }

        public CreateReviewDTOBuilder numberOfStars(final Integer numberOfStars) {
            this.numberOfStars = numberOfStars;
            return this;
        }

        public CreateReviewDTOBuilder reviewDescription(final String reviewDescription) {
            this.reviewDescription = reviewDescription;
            return this;
        }

        public CreateReviewDTOBuilder movieId(final Integer movieId) {
            this.movieId = movieId;
            return this;
        }

        public CreateReviewDTO build() {
            return new CreateReviewDTO(this.numberOfStars, this.reviewDescription, this.movieId);
        }

        public String toString() {
            return "CreateReviewDTO.CreateReviewDTOBuilder(numberOfStars=" + this.numberOfStars + ", reviewDescription=" + this.reviewDescription + ", movieId=" + this.movieId + ")";
        }
    }
}
