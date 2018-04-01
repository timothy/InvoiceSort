type Invoice =
  {
    PartNumber        : int
    Quantity          : int
    Price             : double
    PartDescription   : string
  }
  
  static member Instance(partNumber,quantity,price,description) =
    { PartNumber = partNumber, Quantity = quantity,
      Price = price, PartDescription = description }
      
module InvoiceSort =

  let priceSort (invoice:Invoice) = invoice.Price
  let partDescriptionSort (invoice:Invoice) = invoice.PartDescription
  
  let mapToPartDescriptionAndQuantity (invoice:Invoice) = (invoice.PartDescription, invoice.Quantity)
  let mapToPartDescriptionAndValue (invoice:Invoice) = (invoice.PartDescription, (invoice.Price * invoice.Quantity))
  
  let filterValueToRange l u v = v >= l && v <= u
  
  let printInvoice invoice = printfn "Invoice %A" invoice
  let printResult result = printfn "Result %a" result
  
  let invoices =
    [|
      Invoice.Instance(123456, 56, 108.50, "Cars")
      Invoice.Instance(545555, 27, 11.50, "Boats")
      Invoice.Instance(777777, 15, 13.50, "Planes")
      Invoice.Instance(999999, 32, 115.50, "Spoons")
      Invoice.Instance(121212, 45, 172.50, "Bikes")
      Invoice.Instance(151515, 27, 2.50, "Dirt")
      Invoice.Instance(989898, 57, 194.50, "ARIfot")
      Invoice.Instance(829155, 58, 1.50, "Bats")
      Invoice.Instance(333333, 59, 10.50, "Shoes")
      Invoice.Instance(111111, 70, 129.50, "Food")
    |]
    
  let printPadding() = printfn "\n\n"
    
  [<EntryPoint>]
  let main _ =
    printfn "a. Sort the Invoice objects by PartitionDescription, then display the result."
    
    invoices
    |> Array.sortBy partDescriptionSort
    |> Array.iter printInvoice
    
    printPadding()
    
    printfn "b. Sort the Invoice objects by Price, then display the results."
    
    invoices
    |> Array.sortBy priceSort
    |> Array.iter printInvoice
    
    printPadding()
    
    printfn "c. Map each Invoice to its PartDescription and Quantity, sort the results by Quantity, then display the results."
    
    invoices
    |> Array.map mapToPartDescriptionAndQuantity
    |> Array.sortBy snd // we mapped to a tuble (fst, snd), quantity is in the snd position
    |> Array.iter printResult
    
    printPadding()
    
    printfn "d. Map each Invoice to its PartDescription and the value of the Invoice (i.e., Quantity * Price). Order the results by Invoice value."
    
    invoices
    |> Array.map mapToPartDescriptionAndValue
    |> Array.sortBy snd // we mapped to a tuble (fst, snd), value is in the snd position
    |> Array.iter printResult
    
    printPadding()
    
    printfn "e. Modify Part (d) above to select the Invoice values in the range of $200 to $500 (inclusive) and display the results separately."
    
    nvoices
    |> Array.map mapToPartDescriptionAndValue
    // Filter first to sort few values
    // We have a tuple, `value` is in snd position so use `snd` to pick it out
    // We hard code `200` and `500` as first and second argument to `filterValueToRange`
    // since we still need to fill third argument for `filterValueToRange`
    // we use `>>` to pipe result of `snd` as third argument for `filterValueToRange`
    |> Array.filter (snd >> filterValueToRange 200 500)
    |> Array.sortBy snd // we mapped to a tuble (fst, snd), value is in the snd position
    |> Array.iter printResult
