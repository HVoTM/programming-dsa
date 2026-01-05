#include <iostream>
#include <fstream>
#include <string>
#include <utility> // for std::pair 

int MAX_DIAL = 99; 
int MIN_DIAL = 0;
int STARTING_DIAL = 50;

std::pair<char, int> getDirectionAndSteps(const std::string& input) {
    // NOTE: using reference (&) to avoid copying the string
    // Check if the input string is empty
    if (input.empty()) {
        throw std::invalid_argument("Input string is empty");
    }
    // char direction = input[0];
    char direction = input.front();
    // string method: substr(index, length). index: starting index of the characters to extract, length: number of characters to extract
    int steps = std::stoi(input.substr(1));
    return {direction, steps};
}

int main() {
    // initialize input file stream to read
    std::ifstream inputFile("input.txt");

    if (!inputFile) {
        std::cerr << "Failed to load input.txt" << std::endl;
        return 1;
    }
    if (!inputFile.is_open()) {
        std::cerr << "Error opening file." << std::endl;
        return 1;
    }

    // The problem's starting condition is 50
    int currentDial = STARTING_DIAL;
    int zeroCount = 0;

    std::string line;
    while (std::getline(inputFile, line)) {
        std::cout << line << std::endl;

        // auto: 
        auto [direction, steps] = getDirectionAndSteps(line);
        std::cout << "Direction: " << direction << ", Steps: " << steps << std::endl;
        
        // Remove the number of full rotations
        steps = steps % 100;
        
        // L: rotate left, R: rotate right
        if (direction == 'L') {
            currentDial -= steps;
            if (currentDial < MIN_DIAL) {
                currentDial = ((currentDial) % 100) + 100; // wrap around
            }

            // currentDial = (currentDial - steps) % 100;
            // if (currentDial < 0) {
            //     currentDial += 100;
            // }
        } else if (direction == 'R') {
            currentDial += steps;
            if (currentDial > MAX_DIAL) {
                currentDial %= 100; // wrap around

            }
            
            // simpler
            // currentDial = (currentDial + steps) % 100;
        } else {
            std::cerr << "Invalid direction: " << direction << std::endl;
            continue; // skip invalid input
        }

        std::cout << "Current Dial: " << currentDial << std::endl;

        if (currentDial == 0) {
            zeroCount++;
        }
    }

    std::cout << "The password is: " << zeroCount << std::endl;

    return 0;
}