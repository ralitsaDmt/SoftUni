function ConeAreaVolume(input) {
    let [r, h] = input.map(Number);
    let s = Math.sqrt(r * r + h * h);
    let totalArea = Math.PI * r * (r + s);

    let volume = Math.PI * r * r * h / 3;

    console.log("volume = " + volume.toFixed(2));
    console.log("area = " + totalArea.toFixed(2));
}

ConeAreaVolume([3, 5]);