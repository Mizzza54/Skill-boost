#include <iostream>
#include <vector>
#include <set>

using namespace std;
typedef unsigned long long ll;

int n, m;
vector<ll> plates;

multiset<ll> people;

multiset<ll> sunnyPlaces;

void foundSunnyPlaces() {
    sunnyPlaces.insert(plates[n - 1]);
    ll maxLength = plates[n - 1];
    for (int i = n - 2; i > -1; i--) {
        if (plates[i] > maxLength) {
            sunnyPlaces.insert(plates[i] - maxLength);
            maxLength = plates[i];
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> n >> m;
    plates.resize(n);
    for (int i = 0; i < n; i++) {
        cin >> plates[i];
    }
    for (int i = 0; i < m; i++) {
        ll temp;
        cin >> temp;
        people.insert(temp);
    }
    foundSunnyPlaces();

    ll count = 0;
    for (ll sunnyPlace: sunnyPlaces) {
        for (long human : people) {
            if (sunnyPlace >= human) {
                people.erase(people.lower_bound(human));
                count++;
                break;
            }
        }
    }
    cout << count;
    return 0;
}