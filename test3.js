test('Reverse Customer Review Titles', async({page})=> {
    const searchBox= page.locator(homepage.searchbox);
    const searchIcon= page.locator(homepage.searchicon);
  //1
     await page.goto(homepage.URL);
     console.log("Navigates to Amazon");
  //2
     await searchBox.fill('Smartwatch');
     await searchIcon.click();
});