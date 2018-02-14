#include <iostream>
#include <vector>
#include <map>
#include <utility>


int main(int argc, char* argv[]) {
  std::map< int, std::vector<int> > results;

  std::string inputLine;
  
  std::cout << "Getting input: " << std::endl;
  std::cin >> inputLine;
  
  int cuts[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

  results = cutString(inputLine, cuts);

  std::pair< int, std::vector<int> > firstPair;
  firstPair = results.begin()->first;

  std::cout << "Min-Times: " + std::get<0>(firstPair) << std::endl;
  std::cout << "Cut list: ";

  for (int i = 0; i < std::get<1>(firstPair).size(); i++) {
    std::cout << std::get<0>(firstPair).at(i) << " ";
  }

  return 0;
}


std::map<int, std::vector<int>> cutString(std::string str, int[] cuts) {
  int length = sizeof(cuts)/sizeof(int);
  std::map< int, std::vector<int> > results;
  int minTimes = 0;
  int currentTimes, currentLength;

  std::vector<int> currentCuts;
  currentCuts.reserve(length);

  for (int i = length - 1; i >= 0; i--) {
    currentTimes = 0;
    currentLength = length;
    currentCuts.clear();

    for (int j = i - 1; j >= 0; j--) {
      if (currentLength == 0) {
        break;
      }

      if (length >= cuts[i]) {
        currentTimes += currentLength;
        currentLength -= cuts[i];

        currentCuts.push_back(j);
      }
    }

    if (currentTimes <= minTimes && minTimes > 0) {
      results.clear();
      results.insert(std::pair(minTimes, currentCuts));
    }
  }

  return result;
}
