function figureArea([w, h, W, H]) {
    let area1 = w * h;
    let area2 = W * H;

    let areaMin = Math.min(w, W) * Math.min(h, H);

    let area = area1 + area2 - areaMin;
    console.log(area);
}

figureArea(['2','4', '5','3']);
