# 🎬 Java Movie Recommender System

![Java](https://img.shields.io/badge/Language-Java-orange)
![Status](https://img.shields.io/badge/Project-Completed-brightgreen)
![Course](https://img.shields.io/badge/Duke%20University-Java%20Programming-blue)

## Overview

This project is a **movie recommendation system built in Java using collaborative filtering**.

The system recommends movies to a user based on ratings from other users with similar preferences.  
It was developed as the **Capstone Project for the Duke University Java Programming and Software Engineering Fundamentals Specialization**.

---

## How It Works

1. The system reads movie and rating data from CSV files.
2. Users rate a set of movies.
3. The program calculates **similarity scores between users** based on their ratings.
4. Ratings from the most similar users are used to compute **weighted recommendation scores**.
5. Movies with the highest scores are recommended to the user.

---

## Features

- Collaborative filtering recommendation algorithm
- Efficient data storage using **HashMaps**
- Movie filtering by:
  - Genre
  - Year
  - Director
  - Runtime
- Weighted similarity scoring between users
- HTML-based display of recommended movies
- Interactive recommender interface for the course website

---

## Technologies Used

- Java  
- Object-Oriented Programming  
- HashMaps and ArrayLists  
- CSV file processing  
- HTML output generation  

---

## Main Components

**MovieDatabase**  
Stores movie information and allows quick lookup by movie ID.

**RaterDatabase**  
Stores user ratings and manages rater information.

**FourthRatings**  
Implements the recommendation algorithm and similarity calculations.

**RecommendationRunner**  
Integrates the recommender with the web interface.

---

## Project Structure

```text
movie-recommender/
│
├── project/
│   ├── Java source files
│   └── data/
│       ├── ratings.csv
│       └── ratedmoviesfull.csv
│
├── certificate/
│   └── certificate.pdf
│
└── README.md
```

---

## Course

This project was completed as part of the **Duke University Java Programming Specialization on Coursera**.

---

## Certificate

## Certificate

This project was completed as part of the **Duke University Java Programming and Software Engineering Fundamentals Specialization**.

📜 **Course Certificate:**  
[Java Programming and Software Engineering Fundamentals](certificate/duke-java-certificate.pdf)



