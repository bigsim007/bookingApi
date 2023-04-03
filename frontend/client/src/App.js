import React from 'react';
import './App.css';
import {  Grid, TextField, Button, Card, CardContent, Typography} from '@mui/material';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import dayjs from 'dayjs';
import { LocalizationProvider } from '@mui/x-date-pickers';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs'

function App() {
  return (
    
    <div className="App">
            <Typography gutterBottom variant="h3" align="center">
        Hotel Reservation App
       </Typography>
      <Grid>
        <Card style={{ maxWidth: 450, padding: "20px 5px", margin: "0 auto" }}>
          <CardContent>
            <Typography gutterBottom variant="h5">
              Reservattion Form
          </Typography> 
            <Typography variant="body2" color="textSecondary" component="p" gutterBottom>
              Fill up the form and our team will get back to you within 24 hours.
          </Typography> 
            <form>
              <Grid container spacing={1}>
                <Grid xs={12} sm={6} item>
                  <TextField type="number" placeholder="Enter Number Rooms" label="Number of Rooms" variant="outlined" fullWidth required />
                </Grid>
                <Grid xs={12} sm={6} item>
                  <TextField type="number" placeholder="Price" label="Price" variant="outlined"  />
                </Grid>
                <Grid item xs={12}>
                  <TextField placeholder="Enter room number" label="Room Number" variant="outlined" fullWidth required />
                </Grid>
                <Grid item xs={12}>
                  <TextField type="number" placeholder="Enter Number Of Adults" label="Number Of Adults" variant="outlined" fullWidth required />
                </Grid>
                <Grid item xs={12}>
                  <TextField type="number" placeholder="Enter Number Of Children" label="Number Of Children" variant="outlined" fullWidth required />
                </Grid>                 
                <LocalizationProvider dateAdapter={AdapterDayjs}>
                  <Grid item xs={6}>               
                    <DatePicker label="Uncontrolled picker" defaultValue={dayjs('2022-04-05')} />
                  </Grid>
                  <Grid item xs={6}>  
                    <DatePicker label="Controlled picker" defaultValue={dayjs('2023-04-05')} />
                  </Grid>
                </LocalizationProvider>
                
                <Grid item xs={12}>
                  <Button type="submit" variant="contained" color="primary" fullWidth>Submit</Button>
                </Grid>

              </Grid>
            </form>
          </CardContent>
        </Card>
      </Grid>
    </div>
  

  );
}

export default App;
