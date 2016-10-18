function DistanceOverTime([v1, v2, t]) {
    console.log(Math.abs(v1 * t/3600 - v2 * t/3600) * 1000);
}

DistanceOverTime([0, 60, 3600]);