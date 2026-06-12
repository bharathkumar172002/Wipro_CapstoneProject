# =========================================================================
# DOCKERFILE: Guru99 Banking Automation Environment
# =========================================================================

# 1. Base Image
FROM maven:3.9.6-eclipse-temurin-21

# 2. Environment Variables
ENV DEBIAN_FRONTEND=noninteractive

# 3. Install Google Chrome
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    curl \
    ca-certificates \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google.gpg \
    && echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# 4. Working Directory Setup
WORKDIR /app

# 5. Copy Dependency Configuration (Cache optimization)
COPY pom.xml .
RUN mvn dependency:resolve

# 6. Copy Source Code
COPY . .

# 7. Pre-build Step
RUN mvn clean compile

# 8. Execution Command
CMD ["mvn", "test"]