///<reference types="Cypress"/>

describe('My First Test Suite',function()
{

it('My firstTest case',function() {

cy.visit("https://rahulshettyacademy.com/seleniumPractise/#/");    
cy.get('.search-keyword').type('ca')
cy.wait(2000)
cy.get('.products').as('productlocator')
//cy.get('.product').get(size,4)

cy.get('.product').should('have.length',5)
cy.get('.product:visible').should('have.length',4)
//cy.get('productlocator').find('.product').should('have.length', 4)
cy.get('.products').find('.product').should('have.length', 4)
//cy.get('productlocator').find('.product').eq(0).contains('ADD TO CART').click()

cy.get('.products').find('.product').each(($el, index, $list) => {

    const textVeg=$el.find('h4.product-name').text()
    if(textVeg.includes('Cashews'))
    {
        $el.find('button').click()
    }
})
/*const logo=cy.get('.brand')
cy.log(logo.text)
Above code cypress does not have this sence,
we have to do manually by promise resolved using .then(function(parameter)){}) like bellow code*/

context.logo=cy.get('.brand').then(function(logoelement)
{
cy.log(logoelement.text())
})



} )


} )
