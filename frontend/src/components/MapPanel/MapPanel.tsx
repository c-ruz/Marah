import { Box, Button, Paper, Typography } from '@mui/material'
import { useState } from 'react'
import type { Panel } from '../../types/types.ts'
import EntityDisplay from '../EntityDisplay/EntityDisplay.tsx'
import ActionMenuAsMuiMenu from '../ActionMenu/ActionMenuAsMuiMenu.tsx'
import useGameStore from '../../store/GameStateStore.ts'

const API_URL = 'http://localhost:8080'

interface PanelProps {
  panel: Panel
}

function MapPanel({ panel }: PanelProps) {
  const { label, x, y, actions, entities, img } = panel
  const { doAction, fetchGameState } = useGameStore()
  const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null)

  const backgroundImageUrl = img ? `url(${API_URL}/resources/static/${img})` : 'none'

  const handleClick = async (event: React.MouseEvent<HTMLElement>) => {
    event.stopPropagation()
    if (actions.length == 1) {
      // If there's only one action, perform it directly
      await doAction(actions[0])
      await fetchGameState()
    }
    else {
      setAnchorEl(event.currentTarget)
    }
  }

  const handleClose = () => {
    setAnchorEl(null)
  }

  return (
    <>
      <Paper
        elevation={3}
        sx={{
          minWidth: '300px',
          minHeight: '300px',
          backgroundImage: backgroundImageUrl,
          backgroundSize: 'cover',
          gridColumn: x + 1,
          gridRow: y + 1,
          borderRadius: '1em',
        }}
      >
        <Button
          disableRipple
          variant="text"
          size="small"
          sx={{ width: '100%', height: '100%', justifyContent: 'flex-start', alignItems: 'center', overflow: 'auto' }}
          onClick={handleClick}
          disabled={actions.concat(entities.flatMap(entity => entity.actions)).length === 0}
        >
          <Typography
            variant="caption"
            sx={{
              p: 0.5,
              fontSize: '1em',
              position: 'absolute',
              bottom: 4,
              left: 4,
            }}
          >
            {label}
          </Typography>
          {entities.map((entity, idx) => (
            <Box
              key={`${entity.name}_${idx}`}
              sx={{
                'transition': 'transform 0.2s ease-in-out, box-shadow 0.2s ease-in-out',
                '&:hover': {
                  transform: 'translateY(-8px)',
                  boxShadow: `0 8px 20px -5px rgba(0,0,0,0.3)`,
                },
                'm': 1,
              }}
            >
              <EntityDisplay entity={entity} />
            </Box>
          ))}
        </Button>
      </Paper>
      {actions.length > 0 && (
        <ActionMenuAsMuiMenu
          anchorEl={anchorEl}
          onClose={handleClose}
          menuActions={actions}
        />
      )}
    </>
  )
}

export default MapPanel
