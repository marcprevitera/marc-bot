
# Marc-Bot Deployment Guide

Welcome to the Marc-Bot deployment guide! This document will help you deploy both the frontend and backend of Marc-Bot, and link it to your LinkedIn profile.

## Frontend Deployment (GitHub Pages)

1. **Create a GitHub Repository**
    - Go to [GitHub](https://github.com) and create a new repository (e.g., `marc-bot`).

2. **Upload `index.html`**
    - Upload the `index.html` file to the root of your repository.

3. **Enable GitHub Pages**
    - Go to **Settings > Pages**.
    - Under **Source**, select the `main` branch and save.
    - Your chatbot will be live at `https://yourusername.github.io/marc-bot`.

## Backend Deployment (Render.com)

1. **Sign Up for Render.com**
    - Go to [Render.com](https://render.com) and sign up for a free account.

2. **Create a New Web Service**
    - Create a new **Web Service**.
    - Upload or connect your Spring Boot backend project.

3. **Set Build and Start Commands**
    - Set the build command to `./gradlew build`.
    - Set the start command to `java -jar build/libs/yourapp.jar`.

4. **Deploy the App**
    - Once deployed, copy the backend URL (e.g., `https://marc-bot-backend.onrender.com`).

5. **Update Frontend with Backend URL**
    - Replace the placeholder backend URL in `index.html` with your actual backend URL.

## Linking to LinkedIn

1. **Go to Your LinkedIn Profile**
    - Log in to your LinkedIn account and go to your profile.

2. **Add a Featured Link**
    - Click **Add profile section > Featured > Add a link**.
    - Paste your GitHub Pages URL (e.g., `https://yourusername.github.io/marc-bot`).
    - Give it a title like “Chat with Marc-Bot”.

## Conclusion

Congratulations! You have successfully deployed Marc-Bot. Recruiters can now interact with your chatbot to learn more about you based on your resume and LinkedIn profile.

If you encounter any issues or have any questions, feel free to reach out for support.

Happy chatting!
