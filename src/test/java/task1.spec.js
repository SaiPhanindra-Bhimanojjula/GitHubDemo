test('Verify Technical Details present in Product Description', async ({ page }) => {
   
    // Step 1: Navigate to Amazon India
    await page.goto('https://www.amazon.in');
 
    // Step 2: Search for "Monitor"
    await page.locator('#twotabsearchtextbox').fill('Monitor');
    await page.keyboard.press('Enter');
 
    //3
    await page.locator('[role="listitem"] h2 span').first().waitFor({ state: 'visible' });
    console.log('results loaded')
 
    //4 Click the first product in the search results to navigate to its detail page.
    const [newpage] = await Promise.all([
        page.context().waitForEvent('page'), // Wait for new tab to open
        page.locator('.s-image').first().click(), // Click the first product
    ]);
 
    // await page.locator('.s-image').first().click();
     console.log('clicked 1st product')
 
     //5. Wait for the product detail page to load (ensure the Technical Details section is visible).
    await page.locator('.a-size-large.a-spacing-none')
    console.log('details page loaded')
 
    //6.Locate the Technical Details section (typically a table with key-value pairs).
    await page.locator('#productDetails_techSpec_section_1')
    console.log('technical details present');
 
    const TechnicalDetails = await newpage.locator('#productDetails_techSpec_section_1').textContent();
    console.log("Description:", TechnicalDetails);
 
 
    //7. Extract all text from the Technical Details section (e.g., keys and values like "Brand: Dell", "Screen Size: 27 Inches") into an array.
    const keys = await newpage.locator('#productDetails_techSpec_section_1 th').allInnerTexts();
    const values = await newpage.locator('#productDetails_techSpec_section_1 td').allInnerTexts();
    console.log(values)
    console.log(values.length)
 
    const techDetails = [];
  for (let i = 0; i < keys.length; i++) {
    const detail = `${keys[i].trim()}: ${values[i].trim()}`;
    techDetails.push(detail);
  }
  console.log("technical details:", techDetails);
 
    // const techDetails = keys.map((key, i) => `${key.trim()}: ${values[i].trim()}`);
    // console.log(' Extracted Technical Details');
    // techDetails.forEach(detail => console.log('-', detail));
 
 
// // Step 7: Extract technical details as "Key: Value" array
// const rows = await newpage.locator('#productDetails_techSpec_section_1 tr');
// const technicalDetailsArray = [];
 
// const rowCount = await rows.count();
// for (let i = 0; i < rowCount; i++) {
//     const key = await rows.nth(i).locator('th').textContent();
//     const value = await rows.nth(i).locator('td').textContent();
//     if (key && value) {
//         const formatted = `${key.trim()}: ${value.trim()}`;
//         technicalDetailsArray.push(formatted);
//     }
// }
 
// // Step 8: Display formatted Technical Details
// console.log("\n📋 Technical Details:\n");
// technicalDetailsArray.forEach(item => console.log(item));
 
// await page.locator('#feature-bullets')
// console.log('description is present');
 
//     const productdescription = await newpage.locator('#feature-bullets').textContent();
//     console.log("Description:", productdescription);
 
 
//8 and 9
const descriptionPoints = await newpage.locator('#feature-bullets .a-list-item').allInnerTexts();
const descriptionText = descriptionPoints.map(text => text.trim()).join(' ').toLowerCase();
 
console.log(' Product Description ', descriptionText);
 
let count = 0
for(let i=0; i<values.length; i++){
    if(descriptionText?.includes(values[i]))
    {
    count++
    }
}
console.log(count)
 
if(count>=6){
    console.log('6 items matched')
}else{
    console.log('not matching')
}
 
});